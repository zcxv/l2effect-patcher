class 5122 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect50
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-70.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u832_new_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect51
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_shield_stun_ta'
		bOnMultiTarget=True
	End Object
	Desc="사이렌전용스턴" //Siren -only stun
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect50',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect51',SpecificStage=0)
}
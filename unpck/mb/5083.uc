class 5083 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect60
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.850000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.s_u804_c_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect61
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_shield_stun_ta'
	End Object
	Desc="NPC스턴 어택 트릭" //Stun Attack NPC Tricks
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect60',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect61',SpecificStage=0)
}
class 1078 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.su_empower_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect9
		AttachOn=AM_RA
		AttachBoneName="e_bone"
		bAbsolute=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_concentration_ta'
	End Object
	Desc="콘센트레이션" //Migration outlet
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect9',SpecificStage=0)
}
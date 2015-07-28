class 4316 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		AttachOn=AM_Location
		bAbsolute=True
		EffectClass=Class'LineageEffect.mu_lilim_drain_boss_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_RH
		EffectClass=Class'LineageEffect.mu_lilim_drain_boss_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mu_lilim_drain_boss_ta'
	End Object
	Desc="Boss 릴림 드레인" //Boss rilrim drain
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
}